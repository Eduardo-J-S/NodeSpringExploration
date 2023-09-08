import SelecaoRepository from "../repositories/SelecaoRepository.js"
import logger from "../../logger.js";

class SelecaoController {

    async index(req, res) {
        try {
            const row = await SelecaoRepository.findAll();
            logger.info('Lista de seleções consultada');
            res.json(row);
          } catch (error) {
            logger.error(`Erro ao consultar seleções: ${error.message}`);
            res.status(500).json({ error: 'Erro interno do servidor' });
          }
    }

    async show(req, res) {
        const id = req.params.id;
        try {
            const row = await SelecaoRepository.findById(id);
            if (!row) {
            logger.warn(`Tentativa de consultar seleção inexistente (ID: ${id})`);
            return res.status(404).json({ error: 'Seleção não encontrada' });
            }
            logger.info(`Consulta da seleção com ID ${id}`);
            res.json(row);
        } catch (error) {
            logger.error(`Erro ao consultar seleção: ${error.message}`);
            res.status(500).json({ error: 'Erro interno do servidor' });
        }
    }
    
    async store(req, res) {
        const selecao = req.body
        try {
            const row = await SelecaoRepository.create(selecao);
            logger.info(`Nova seleção adicionada: ${JSON.stringify(selecao)}`);
            res.json(row);
        } catch (error) {
            logger.error(`Erro ao adicionar seleção: ${error.message}`);
            res.status(500).json({ error: 'Erro interno do servidor' });
        }       
    }

    async update(req, res) {
        const selecao = req.body;
        const id = req.params.id;
        try {
            const row = await SelecaoRepository.update(selecao, id);
            if (!row) {
            logger.warn(`Tentativa de atualizar seleção inexistente (ID: ${id})`);
            return res.status(404).json({ error: 'Seleção não encontrada' });
            }
            logger.info(`Seleção atualizada com sucesso (ID: ${id})`);
            res.json(row);
        } catch (error) {
            logger.error(`Erro ao atualizar seleção: ${error.message}`);
            res.status(500).json({ error: 'Erro interno do servidor' });
        }
    }

    async delete(req, res) {
        const id = req.params.id;
        try {
          const row = await SelecaoRepository.delete(id);
          if (!row) {
            logger.warn(`Tentativa de excluir seleção inexistente (ID: ${id})`);
            return res.status(404).json({ error: 'Seleção não encontrada' });
          }
          logger.info(`Seleção excluída com sucesso (ID: ${id})`);
          res.json(row);
        } catch (error) {
          logger.error(`Erro ao excluir seleção: ${error.message}`);
          res.status(500).json({ error: 'Erro interno do servidor' });
        }
    }
}

// padrão singleton
export default new SelecaoController();