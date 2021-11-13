import express from 'express';
import { Sequelize, Model, DataTypes } from 'sequelize';

const port = process.env.PORT || 3000;
const app = express();
const sequelize = new Sequelize('sqlite::memory:');

// model
class Student extends Model {};
Student.init({
    name: DataTypes.STRING,
    email: DataTypes.STRING,
    ra: DataTypes.number,
    }, {sequelize, modelName: 'Student'}
);
// model-end

// endpoints
app.get('/students', (req, res) => {
    // do logic
});

app.get('/students/:id', (req, res) => {
    // do logic
});

app.post('/students/:id', (req, res) => {
    // do logic
});

app.put('/students/:id', (req, res) => {
    // do logic
});

app.delete('/students/:id', (req, res) => {
    // do logic
});
// endpoints-end

app.listen(port, () => {
    console.log(`Server running at localhost:${port}`);
});
