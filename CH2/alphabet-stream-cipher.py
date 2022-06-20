ALPHABET = "abcdefghijklmnopqrstuvwxyz"

def encrypt(cipher_text: str, key: str) -> str:
	plain_text = ""
	for i in range(len(cipher_text)):
		if cipher_text[i] in ALPHABET and key[i] in ALPHABET:
			y = ALPHABET.index(cipher_text[i])
			s = ALPHABET.index(cipher_text[i])
			x = (y - s) % 26
			plain_text = plain_text + ALPHABET[x]
		else:
			plain_text = plain_text + cipher_text[i]
	return plain_text
	
if name == "__main__":
	cipher_text = "bsaspp kkuosp"
	key = "rsidpy dkawoa"
	plain_text = decrypt(cipher_text, key)
	print(plain_text)
