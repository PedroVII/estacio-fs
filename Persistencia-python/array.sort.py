import random


def exibir(titulo, arr):
	print(f"{titulo}: {arr}")


def exemplo_numeros():
	numeros = [random.randint(0, 99) for _ in range(15)]
	numeros.sort()
	exibir("Números (crescente)", numeros)
	numeros.sort(key=None, reverse=True)
	exibir("Números (decrescente)", numeros)


def exemplo_strings():
	campos = ["nome", "dataNascimento", "cpf", "rg"]
	campos.sort()
	exibir("Strings (crescente)", campos)
	campos.sort(key=None, reverse=True)
	exibir("Strings (decrescente)", campos)


def main():
	exemplo_numeros()
	print("-")
	exemplo_strings()


if __name__ == "__main__":
	main()

