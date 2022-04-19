let jogador,vencedor = null;
const jogadorSelecionado = document.getElementById('jogador-selecionado')
const jogadorGanhador = document.getElementById('jogador-vencedor') 
const quadrados = document.querySelector('.quadrado')
let contador = 0
const quadrado1 = document.getElementById(1)
const quadrado2 = document.getElementById(2)
const quadrado3 = document.getElementById(3)
const quadrado4 = document.getElementById(4)
const quadrado5 = document.getElementById(5)
const quadrado6 = document.getElementById(6)
const quadrado7 = document.getElementById(7)
const quadrado8 = document.getElementById(8)
const quadrado9 = document.getElementById(9)

mudarJogador('X')

function escolherQuadrado(id){

    const quadrado = document.getElementById(id)

    if (quadrado.innerHTML !== '-') {
        return
    }

    quadrado.innerHTML = jogador
    quadrado.style.color = '#000'

    if (jogador === 'X') {
        mudarJogador('O')
    }else{
        mudarJogador('X')
    }
    contador++
    console.log(contador)
    checaVencedor()
    checarEmpate()
}

function mudarJogador(valor){
    jogador = valor
    jogadorSelecionado.innerHTML = jogador
}

function checaVencedor(){

    if (checaSequencia(quadrado1, quadrado2, quadrado3)) {
        mudaCorQuadrado(quadrado1, quadrado2, quadrado3);
        mudarVencedor(quadrado1)
        return;
    }

    if (checaSequencia(quadrado4, quadrado5, quadrado6)) {
        mudaCorQuadrado(quadrado4, quadrado5, quadrado6);
        mudarVencedor(quadrado4)
        return;
    }

    if (checaSequencia(quadrado7, quadrado8, quadrado9)) {
        mudaCorQuadrado(quadrado7, quadrado8, quadrado9);
        mudarVencedor(quadrado7)
        return;
    }

    if (checaSequencia(quadrado1, quadrado4, quadrado7)) {
        mudaCorQuadrado(quadrado1, quadrado4, quadrado7);
        mudarVencedor(quadrado1)
        return;
    }

    if (checaSequencia(quadrado2, quadrado5, quadrado8)) {
        mudaCorQuadrado(quadrado2, quadrado5, quadrado8);
        mudarVencedor(quadrado2)
        return;
    }

    if (checaSequencia(quadrado3, quadrado6, quadrado9)) {
        mudaCorQuadrado(quadrado3, quadrado6, quadrado9);
        mudarVencedor(quadrado3)
        return;
    }

    if (checaSequencia(quadrado1, quadrado5, quadrado9)) {
        mudaCorQuadrado(quadrado1, quadrado5, quadrado9)
        mudarVencedor(quadrado1)
        return;
    }

    if (checaSequencia(quadrado3, quadrado5, quadrado7)) {
        mudaCorQuadrado(quadrado3, quadrado5, quadrado7)
        mudarVencedor(quadrado3)
    }
}

function mudarVencedor(quadrado) {
    vencedor = quadrado.innerHTML
    jogadorGanhador.innerHTML = vencedor
}

function mudaCorQuadrado(quadrado1, quadrado2, quadrado3) {
    quadrado1.style.background = '#0f0'
    quadrado2.style.background = '#0f0'
    quadrado3.style.background = '#0f0'
}

function checaSequencia(quadrado1, quadrado2, quadrado3) {
    var eigual = false

    if (quadrado1.innerHTML !== '-' && quadrado1.innerHTML === quadrado2.innerHTML && quadrado2.innerHTML === quadrado3.innerHTML) {
        eigual = true
    }

    return eigual;
}

function checarEmpate(){
    if (contador == 9) {
        jogadorGanhador.innerHTML = 'Empate'
        pintarTodos()
    }
}

function pintarTodos(){
    quadrado1.style.background = 'red'
    quadrado2.style.background = 'red'
    quadrado3.style.background = 'red'
    quadrado4.style.background = 'red'
    quadrado5.style.background = 'red'
    quadrado6.style.background = 'red'
    quadrado7.style.background = 'red'
    quadrado8.style.background = 'red'
    quadrado9.style.background = 'red'
}

function reiniciar(){
    vencedor = null
    jogadorGanhador.innerHTML = ''
    contador = 0

    for (var i = 1; i <= 9; i++) {
        var quadrado = document.getElementById(i)
        quadrado.style.background = '#eee'
        quadrado.style.color = '#eee'
        quadrado.innerHTML = '-'
    }

    mudarJogador('X')
}