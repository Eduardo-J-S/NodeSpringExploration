const express = require('express');
const router = express.Router();
const UserController = require('../controllers/UserController');

// Listar todos os usuários
router.get('/', UserController.index);

// Listar usuário por id
router.get('/:id', UserController.show);

// Criar um novo usuário
router.post('/', UserController.store);

module.exports = router;
