import random


def selectionSort(array):
	for i in range(len(array)):
		min_index = i
		for j in range(i + 1, len(array)):
			if array[min_index] > array[j]:
				min_index = j
		temp = array[i]
		array[i] = array[min_index]
		array[min_index] = temp


def main():
	numeros = [random.randint(0, 99) for _ in range(15)]
	print(f"Array inicial: {numeros}")
	selectionSort(numeros)
	print(f"Array ordenado: {numeros}")


if __name__ == "__main__":
	main()
