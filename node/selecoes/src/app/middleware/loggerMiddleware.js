import logger from "../../logger.js";

// Middleware para logging de solicitações
const loggerMiddleware = (req, res, next) => {
    logger.info(`[${req.method}] ${req.url}`);
    next();
};
  
export default loggerMiddleware;
