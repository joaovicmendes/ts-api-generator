import express from 'express';
import { Sequelize, Model, DataTypes } from 'sequelize';

const port = process.env.PORT || 3000;
const app = express();
app.use(express.json());
const sequelize = new Sequelize('sqlite::memory:');

// model
class Student extends Model {};
Student.init({
        name: DataTypes.STRING,
        email: DataTypes.STRING,
        ra: DataTypes.NUMBER,
    }, {sequelize, modelName: 'Student'}
);

const initModel = async () => {
    await sequelize.sync();
}
initModel();
// model-end

// endpoints
app.get('/students', async (req, res) => {
    const variable = await Student.findAll();
    res.status(200).send(JSON.stringify(variable));
});

app.get('/students/:ra', async (req, res) => {
    const variable = await Student.findOne({
        where: {
            ra: req.params.ra
        }
    });
    res.status(200).send(JSON.stringify(variable));
});

app.post('/students', async (req, res) => {
    const variable = await Student.create(req.body);
    res.status(200).send(JSON.stringify(variable));
});

app.put('/students/:ra', async (req, res) => {
    Student.update(req.body, {
        where: {
            ra: req.params.ra
        }
    });
    res.status(200).send();
});

app.delete('/students/:ra', async (req, res) => {
    Student.destroy({
        where: {
            ra: req.params.ra
        }
    });
    res.status(200).send();
});

// endpoints-end

app.listen(port, () => {
    console.log(`Server running at localhost:${port}`);
});

