import express from 'express';
import SelecaoController from './app/controllers/selecaoController.js'

const app = express();

// indicar para para o express ler body com json
app.use(express.json());

// retornar o objeto por id
function buscarSelecaoPorId(id){
    return selecoes.filter(selecao => selecao.id == id)
}

// pegar a posição ou index do elemendo no array por id
function buscarIndexSelecao(id){
    return selecoes.findIndex(selecao => selecao.id == id)
}

// ROTAS
app.get('/selecoes', SelecaoController.index)

app.get('/selecoes/:id', SelecaoController.show)

app.post('/selecoes', SelecaoController.store)

app.put('/selecoes/:id', SelecaoController.update)

app.delete('/selecoes/:id', SelecaoController.delete)


export default app;