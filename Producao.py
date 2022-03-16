import pyautogui
import time
from selenium                          import webdriver
#import playwrite.sync_api
#pyinstaller --onefile

#Tempo de Inicializar
time.sleep(5)

#Ir para área de trabalho
pyautogui.hotkey('winleft', 'd')

#Abrindo o browser  -  ABA 1
Navegador = webdriver.Chrome()
time.sleep(5)

#Abrindo o Site do Power BI
url_1 = "https://powerbi.microsoft.com/pt-br/"
Navegador.get(url_1)
Navegador.maximize_window()
time.sleep(5)
original_window = Navegador.current_window_handle



#####--------------------------#####
# ------   Logando na conta   ------
#     *****  Email  *****
email =

Navegador.find_element_by_id("power-bi-portal-link-desktop").click()    #Botão entrar
time.sleep(10)

#------------------------------------------------------------------------------------
#Verificando aba dupla - Microsoft FDP vive mudando isso
#Quando vai logar, abre outra ABA
i = 1
Aba_1 = Aba_2 = 0
for window in Navegador.window_handles:
    if window != original_window:
        Navegador.close()
        Navegador.switch_to.window(window)
        i += 1
#------------------------------------------------------------------------------------

Navegador.find_element_by_xpath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div[1]/div[3]/div/div/div/div[2]/div[2]/div/input[1]").send_keys(email)     #Campo de email
Navegador.find_element_by_id("idSIButton9").click()        #Botão avançar/logar

#Escolhendo o tipo de conta. OBS: É pedido nessa conta da TI
  #time.sleep(5)
#       ***** Senha *****
  #Navegador.find_element_by_id('aadTile').click()

time.sleep(5)
key =
Navegador.find_element_by_id("i0118").send_keys(key)
Navegador.find_element_by_id('idSIButton9').click()

# Pulando verificação Stay Signed in
time.sleep(2)
Navegador.find_element_by_xpath('//*[@id="KmsiCheckboxField"]').click()
Navegador.find_element_by_xpath('//*[@id="idSIButton9"]').click()
#####-----
#####-----
#####-----





# Abrindo pagina direto do painel, após logar na conta
time.sleep(4)
url_1 = **********
Navegador.get(url_1)
Aba_1 = Navegador.current_window_handle

# Abrindo 4 abas para memorização de posição
for X in range(4):
    Navegador.execute_script("window.open()")
    time.sleep(3)
    
#Primeira Aba como Aba_1
Navegador.switch_to.window(Aba_1)

#Loop para encontrar Aba 2
i = 0
Aba_2 = Aba_3 = Aba_4 = Aba_5 = 0
for window in Navegador.window_handles:
    if i == 1:
        Aba_2 = window
    if i == 2:
        Aba_3 = window
    if i == 3:
        Aba_4 = window    
    if i == 4:
        Aba_5 = window    
    i += 1

#Links
url_2 = 
url_3 = 
url_4 = 
url_5 = 

# Pegando a posição no loop a cima
# Abrindo link 2
time.sleep(10)
Navegador.switch_to.window(Aba_2)
time.sleep(2)
Navegador.get(url_2)

# Abrindo Link 3
time.sleep(10)
Navegador.switch_to.window(Aba_3)
time.sleep(2)
Navegador.get(url_3)

# Abrindo Link 4
time.sleep(10)
Navegador.switch_to.window(Aba_4)
time.sleep(2)
Navegador.get(url_4)

# Abrindo Link 5
time.sleep(10)
Navegador.switch_to.window(Aba_5)
time.sleep(2)
Navegador.get(url_5)


# Loop de repetição infinita 
#Auternando entre abas em horários pré definidos para Turno I e Turno II
i = 40                             
while 1:
    #If para tirar print do Primeiro Turno
    #Intervalo entre horas
    Hora = time.localtime()
    if (Hora[3] >= 5 and (Hora[3] < 16)): 
        if (Hora[3] == 15 and Hora[4] > 15):  #O intervalo das 15h, entre 00 e 28min    
            time.sleep(12)
            Navegador.switch_to.window(Aba_2)
            time.sleep(10)
            Imagem_Turno = Navegador.save_screenshot('Prod-Completo.png')
            
            time.sleep(5)
            Navegador.switch_to.window(Aba_4)
            time.sleep(10)
            Imagem_Turno = Navegador.save_screenshot('Prod-TV.png')
            time.sleep(120)
        
        else:
            time.sleep(12)
            Navegador.switch_to.window(Aba_1)
            time.sleep(10)
            Imagem_Turno = Navegador.save_screenshot('Prod-Completo.png')
            
            time.sleep(5)
            Navegador.switch_to.window(Aba_3)
            time.sleep(10)
            Imagem_Turno = Navegador.save_screenshot('Prod-TV.png')
            time.sleep(120)
    
    else:
        time.sleep(12)
        Navegador.switch_to.window(Aba_2)
        time.sleep(10)
        Imagem_Turno = Navegador.save_screenshot('Prod-Completo.png')
        
        time.sleep(5)
        Navegador.switch_to.window(Aba_4)
        time.sleep(10)
        Imagem_Turno = Navegador.save_screenshot('Prod-TV.png')
        time.sleep(120)
    
    if i >= 40:
        i = 0
        time.sleep(20)
        Navegador.switch_to.window(Aba_5)
        Pos_Vendas = Navegador.save_screenshot('Pos-Vendas.png')
    i += 1






