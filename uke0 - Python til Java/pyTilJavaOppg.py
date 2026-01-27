class Person:
    def __init__(self, alder, navn):
        self._alder = alder
        self._navn = navn
           
    def skriv(self):
        print(self._navn, self._alder)
        
    def bursdag(self):
        self._alder += 1