const express = require('express');
const app = express();
const port = process.env.PORT || 3000;

app.use(express.json());

// Configuração das rotas
const userRoutes = require('./routes/userRoutes');
app.use('/api/users', userRoutes);

app.listen(port, () => {
  console.log(`Servidor rodando na porta ${port}`);
});
