import time


def bubbleSort(array):
	for i in range(len(array)):
		for j in range(0, len(array) - i - 1):
			if array[j] > array[j + 1]:
				temp = array[j]
				array[j] = array[j + 1]
				array[j + 1] = temp


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
	palavras = list()
	print("Lendo arquivo 'loremipsum.txt'...")
	with open("loremipsum.txt", "r", encoding="utf-8") as arquivo:
		for linha in arquivo:
			palavras_da_linha = linha.split()
			for palavra in palavras_da_linha:
				palavras.append(palavra)

	print(f"Total de palavras lidas: {len(palavras)}\n")

	print("=" * 60)
	print("MÉTODO 1: BUBBLE SORT")
	print("=" * 60)

	palavras_bubble = palavras.copy()
	inicio = time.time()
	bubbleSort(palavras_bubble)
	fim = time.time()
	tempo_bubble = fim - inicio

	print(f"Tempo de execução: {tempo_bubble:.6f} segundos")
	print(f"Primeiras 10 palavras: {palavras_bubble[:10]}")
	print(f"Últimas 10 palavras: {palavras_bubble[-10:]}\n")

	print("=" * 60)
	print("MÉTODO 2: SELECTION SORT")
	print("=" * 60)

	palavras_selection = palavras.copy()
	inicio = time.time()
	selectionSort(palavras_selection)
	fim = time.time()
	tempo_selection = fim - inicio

	print(f"Tempo de execução: {tempo_selection:.6f} segundos")
	print(f"Primeiras 10 palavras: {palavras_selection[:10]}")
	print(f"Últimas 10 palavras: {palavras_selection[-10:]}\n")

	print("=" * 60)
	print("MÉTODO 3: MÉTODO NATIVO SORT()")
	print("=" * 60)

	palavras_sort = palavras.copy()
	inicio = time.time()
	palavras_sort.sort()
	fim = time.time()
	tempo_sort = fim - inicio

	print(f"Tempo de execução: {tempo_sort:.6f} segundos")
	print(f"Primeiras 10 palavras: {palavras_sort[:10]}")
	print(f"Últimas 10 palavras: {palavras_sort[-10:]}\n")

	print("=" * 60)
	print("COMPARAÇÃO DE PERFORMANCE")
	print("=" * 60)
	print(f"Bubble Sort:     {tempo_bubble:.6f} segundos")
	print(f"Selection Sort:  {tempo_selection:.6f} segundos")
	print(f"Sort() nativo:   {tempo_sort:.6f} segundos")

	metodos = {
		"Bubble Sort": tempo_bubble,
		"Selection Sort": tempo_selection,
		"Sort() nativo": tempo_sort
	}
	mais_rapido = min(metodos, key=metodos.get)
	print(f"\n✅ Método mais rápido: {mais_rapido}")
	print(f"   Tempo: {metodos[mais_rapido]:.6f} segundos\n")

	print("=" * 60)
	print("SALVANDO RESULTADO")
	print("=" * 60)

	with open("palavras_ordenadas.txt", "w", encoding="utf-8") as arquivo_saida:
		for palavra in palavras_sort:
			arquivo_saida.write(palavra + "\n")

	print("Arquivo 'palavras_ordenadas.txt' criado com sucesso!")
	print(f"Total de palavras salvas: {len(palavras_sort)}")


if __name__ == "__main__":
	main()
