import { Router } from "express";
import SelecaoController from "./app/controllers/selecaoController.js";

const router = Router();

// ROTAS
router.get('/selecoes', SelecaoController.index)
router.get('/selecoes/:id', SelecaoController.show)
router.post('/selecoes', SelecaoController.store)
router.put('/selecoes/:id', SelecaoController.update)
router.delete('/selecoes/:id', SelecaoController.delete)

export default router;
