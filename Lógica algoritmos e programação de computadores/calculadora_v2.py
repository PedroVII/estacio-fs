
def adicao(n1,n2):
    return n1 + n2

def subtracao(n1,n2):
    return n1 - n2

def multiplicacao(n1,n2):
    return n1 * n2

def divisao(n1,n2):
    return n1 / n2


def calculadora(num1,op,num2):
   

   if op == '+':
      print(num1, "+", num2, "=",
           adicao(num1,num2))
      resultado = adicao(num1,num2)
      
   elif op == '-':
    print(num1, "-", num2, "=",
          subtracao(num1,num2))
    resultado = subtracao(num1,num2)
    
   elif op == '*':
    print(num1, "*", num2, "=",
          multiplicacao(num1,num2))
    resultado = multiplicacao(num1,num2)
    
   elif op == '/':
    print(num1, "/", num2, "=",
          divisao(num1,num2))
    resultado = divisao(num1,num2)
   else:
      print("operação inválida")
   return resultado

while True:
   num1 = float(input('Digite o primeiro número: '))
   op = input('Digite a operação a ser feita (+, -, *, /): ')

   if op not in ['+','-','*','/']:
      print('Operação inválida!')
      break

   num2 = float(input('Digite o segundo número: '))
   #calculadora(num1,op,num2)
   resultado = calculadora(num1,op,num2)
   print('Resultado da operação: ',resultado)
   saida = input('Deseja continuar o programa? S/N')
   if saida.lower() in ['s', 'S']:
      print('Continuando...')

   elif saida.lower() in ['n', 'N']:
      print('Fim do programa...')
      break

   else:
      print('Caractere inválido!')
   

