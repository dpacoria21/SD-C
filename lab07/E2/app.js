require('dotenv').config();

const express = require('express');
const cors = require('cors');

const app = express();
const PORT = process.env.PORT || 5500;

app.use(express.json());
app.use(cors());

app.use('/api/calculator', require('./routes/calculator'));

app.listen(PORT, () => {
    console.log(`Listening on port: http://localhost:${PORT}`);
})