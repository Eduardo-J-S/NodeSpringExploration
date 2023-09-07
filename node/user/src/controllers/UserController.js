const User = require('../models/User');

const users = [];

class UserController {

  // Listar todos os usuários
  index(req, res) {
    res.json(users);
  }

  // Listar usuário por id
  show(req, res) {
    const userId = parseInt(req.params.id, 10); // Extrai o ID da solicitação
    const user = users.find((u) => u.id === userId); // Procura o usuário pelo ID

    if (!user) {
      return res.status(404).json({ error: 'Usuário não encontrado' });
    }

    return res.json(user);
  }

  // Criar um novo usuário
  store(req, res) {
    const { name, email } = req.body;
    const user = new User(users.length + 1, name, email);
    users.push(user);
    res.status(201).json(user);
  }
}




module.exports = new UserController();
