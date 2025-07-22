/*const swap = (array, i, j) => {
    [array[i], array[j]] = [array[j], array[i]];
}

const shuffle = (valores, trocas) => {
    for (let i = 0; i < trocas; i++) {
        const idx1 = Math.floor(Math.random() * valores.length);
        const idx2 = Math.floor(Math.random() * valores.length);
        [valores[idx1], valores[idx2]] = [valores[idx2], valores[idx1]];
    }
    return valores;
}

const bubbleSort = (valores) => {
    let n = valores.length;
    for (let i = 0; i < n - 1; i++) {
        for (let j = 0; j < n - 1 - i; j++) {
            if (valores[j] > valores[j + 1]) {
                [valores[j], valores[j + 1]] = [valores[j + 1], valores[j]];
            }
        }
    }
    return valores;
}

const selectionSort = (valores) => {
    let n = valores.length;
    for (let i = 0; i < n - 1; i++) {
        let minIndex = i;
        for (let j = i + 1; j < n; j++) {
            if (valores[j] < valores[minIndex]) {
                minIndex = j;
            }
        }
        if (minIndex !== i) {
            [valores[i], valores[minIndex]] = [valores[minIndex], valores[i]];
        }
    }
    return valores;
}

const quickSort = (valores, inicio, fim) => {
    if (inicio < fim) {
        const pivoIndex = particionamento(valores, inicio, fim);
        quickSort(valores, inicio, pivoIndex - 1);
        quickSort(valores, pivoIndex + 1, fim);
    }
    return valores;
}

const particionamento = (valores, inicio, fim) => {
    const pivo = valores[fim];
    let i = inicio - 1;
    for (let j = inicio; j < fim; j++) {
        if (valores[j] <= pivo) {
            i++;
            [valores[i], valores[j]] = [valores[j], valores[i]];
        }
    }
    [valores[i + 1], valores[fim]] = [valores[fim], valores[i + 1]];
    return i + 1;
}

function add() {

}
*/

// a) Função swap
const swap = (vetor, n1, n2) => {
    [vetor[n1], vetor[n2]] = [vetor[n2], vetor[n1]]
};

// b) Função shuffle
const shuffle = (vetor, trocas) => {
    for (let i = 0; i < trocas; i++) {
        const n1 = Math.floor(Math.random() * vetor.length)
        const n2 = Math.floor(Math.random() * vetor.length)
        swap(vetor, n1, n2);
    }
    return vetor;
};

// c) Função bubble_sort
const bubble_sort = (vetor) => {
    for (let i = 0; i < vetor.length - 1; i++) {
        for (let j = 0; j < vetor.length - 1 - i; j++) {
            if (vetor[j] > vetor[j + 1]) {
                swap(vetor, j, j + 1)
            }
        }
    }
    return vetor;
}

// d) Função selection_sort
const selection_sort = (vetor) => {
    for (let i = 0; i < vetor.length - 1; i++) {
        let min = i
        for (let j = i + 1; j < vetor.length; j++) {
            if (vetor[j] < vetor[min]) {
                min = j
            }
            if (min !== i) {
                swap(vetor, i, min)
            }
        }
    }
}

// e) Função quick_sort
const quick_sort = (vetor, inicio, fim) => {
    if (inicio < fim) {
        const pivoIndex = particionamento(vetor, inicio, fim);
        quick_sort(vetor, inicio, pivoIndex - 1);
        quick_sort(vetor, pivoIndex + 1, fim);
    }
    return vetor;
};

// f) Função particionamento
const particionamento = (vetor, inicio, fim) => {
    const pivo = vetor[fim];
    let i = inicio - 1;
    for (let j = inicio; j < fim; j++) {
        if (vetor[j] <= pivo) {
            i++;
            swap(vetor, i, j);
        }
    }
    swap(vetor, i + 1, fim);
    return i + 1;
};