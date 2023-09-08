import express from 'express';
import routes from './routes.js'
import loggerMiddleware from './app/middleware/loggerMiddleware.js';

const app = express();

// Middleware para logging de solicitações
app.use(loggerMiddleware);

// indicar para para o express ler body com json
app.use(express.json());

// usar o router
app.use(routes)

export default app;