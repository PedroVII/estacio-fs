import random


def bubbleSort(array):
	for i in range(len(array)):
		for j in range(0, len(array) - i - 1):
			if array[j] > array[j + 1]:
				temp = array[j]
				array[j] = array[j + 1]
				array[j + 1] = temp


def main():
	numeros = [random.randint(0, 99) for _ in range(15)]
	print(f"Array inicial: {numeros}")

	bubbleSort(numeros)

	print(f"Array ordenado: {numeros}")


if __name__ == "__main__":
	main()

