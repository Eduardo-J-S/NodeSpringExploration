import conexao from "../database/conexao.js"

class SelecaoController {

    index(req, res) {
        //res.status(200).send(selecoes)
        const sql = "SELECT * FROM selecoes;"
        conexao.query(sql, (erro, resultado) => {
            if (erro) {
                res.status(404).json({ 'erro': 'Dados não localizados ' + erro })
            } else {
                res.status(200).json(resultado)
            }
        })
    }

    show(req, res) {
        //res.json(buscarSelecaoPorId(req.params.id))
        const id = req.params.id
        const sql = "SELECT * FROM selecoes WHERE id=?;"
        conexao.query(sql, id, (erro, resultado) => {
            const linha = resultado[0]
            if (erro) {
                res.status(404).json({ 'erro': 'Dados não localizados ' + erro })
            } else {
                res.status(200).json(linha)
            }
        })
    }
    
    store(req, res) {
        //selecoes.push(req.body)
        //res.status(201).send('Seleção cadastra com sucesso.')
        const selecao = req.body
        const sql = "INSERT INTO selecoes SET ?;"
        conexao.query(sql, selecao, (erro, resultado) => {
            if(erro){
                res.status(404).json({'erro' : 'Dados não localizados ' + erro})
            } else {
                res.status(201).json(resultado)
            }
        })
    }

    update(req, res) {
        // let index = buscarIndexSelecao(req.params.id)
        // selecoes[index].selecao = req.body.selecao
        // selecoes[index].grupo = req.body.grupo
        // res.send(selecoes)
        const selecao = req.body
        const id = req.params.id
        const sql = "UPDATE selecoes SET ? WHERE id=?;"
        conexao.query(sql, [selecao, id], (erro, resultado) => {
            if(erro){
                res.status(404).json({'erro' : 'Dados não localizados ' + erro})
            } else {
                res.status(200).json(resultado)
            }
        })
    }

    delete(req, res) {
        // let index = buscarIndexSelecao(req.params.id)
        // selecoes.splice(index, 1)
        // res.send(`Seleção com o id ${req.params.id} excluída com sucesso`)
        const id = req.params.id
        const sql = "DELETE FROM selecoes WHERE id=?;"
        conexao.query(sql, id, (erro, resultado) => {
            if(erro){
                res.status(404).json({'erro' : 'Dados não localizados ' + erro})
            } else {
                res.status(200).json(resultado)
            }
        })
    }
}

// padrão singleton
export default new SelecaoController();