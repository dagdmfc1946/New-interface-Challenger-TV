"""Restore the exact original ZIP from its authenticated encrypted copy (cryptography required)."""
import argparse
import base64
import hashlib
import json
from pathlib import Path
from cryptography.hazmat.primitives.ciphers.aead import AESGCM

MAGIC = b'CHTVBKP1'
parser = argparse.ArgumentParser()
parser.add_argument('--input', required=True, type=Path)
parser.add_argument('--key-file', required=True, type=Path)
parser.add_argument('--output', required=True, type=Path)
args = parser.parse_args()
if args.output.exists():
    raise SystemExit('El archivo de destino ya existe; elige otro para no sobrescribirlo.')
blob = args.input.read_bytes()
if not blob.startswith(MAGIC) or len(blob) < 36:
    raise SystemExit('Formato de respaldo no reconocido.')
info = json.loads(args.key_file.read_text(encoding='utf-8'))
key = base64.b64decode(info['key_b64'], validate=True)
plain = AESGCM(key).decrypt(blob[8:20], blob[20:], MAGIC)
digest = hashlib.sha256(plain).hexdigest()
if digest != info['original_zip_sha256']:
    raise SystemExit('No coincide el SHA256 del ZIP original; no se escribió ningún archivo.')
args.output.write_bytes(plain)
print('ZIP original recuperado y verificado. SHA256:', digest)
