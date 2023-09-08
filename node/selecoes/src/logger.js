import { createLogger, format, transports } from 'winston';
import MySQLTransport from 'winston-mysql';

const logger = createLogger({
  level: 'info',
  format: format.combine(
    format.timestamp(),
    format.json()
  ),
  transports: [
    new transports.Console(),
    new transports.File({ filename: 'error.log', level: 'error' }),
    new MySQLTransport({
      host: 'localhost',
      user: 'root',
      password: 'admin',
      database: 'bd_copa',
      table: 'logs' // Nome da tabela onde os logs serão armazenados
    })
  ]
});

export default logger;
