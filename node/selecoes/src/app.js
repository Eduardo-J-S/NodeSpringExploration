import express from 'express';

const app = express();

// indicar para para o express ler body com json
app.use(express.json());

// mock
const selecoes = [
    {id: 1, selecao: 'Brasil', grupo: 'G'},
    {id: 2, selecao: 'Suiça', grupo: 'G'},
    {id: 3, selecao: 'Servia', grupo: 'G'},
    {id: 4, selecao: 'Camarões', grupo: 'G'},
]

function buscarSelecaoPorId(id){
    return selecoes.filter(selecao => selecao.id == id)
}

// pegar a posição ou index do elemendo no array por id
function buscarIndexSelecao(id){
    return selecoes.findIndex(selecao => selecao.id == id)
}

// criar rota padrão ou  raiz
app.get('/', (req, res)=> {
    res.send('Hello, world!')
})

app.get('/selecoes', (req, res) => {
    res.status(200).send(selecoes)
})

app.get('/selecoes/:id', (req, res) => {
    res.json(buscarSelecaoPorId(req.params.id))
})

app.post('/selecoes', (req, res) => {
    selecoes.push(req.body)
    res.status(201).send('Seleção cadastra com sucesso.')
})

app.delete('/selecoes/:id', (req, res) => {
    let index = buscarIndexSelecao(req.params.id)
    selecoes.splice(index, 1)
    res.send(`Seleção com o id ${req.params.id} excluída com sucesso`)
})

export default app;