const { Router } = require("express");

const router = Router();

router.post('/add', (req = Request, res = Response) => {
    let { num1, num2 } = req.body;

    num1 = +num1;
    num2 = +num2;

    if (num1 === undefined || num2 === undefined || isNaN(num1) || isNaN(num2)) {
        return res.status(400).json({
            errorMessage: 'No se puede realizar la operacion, ingrese los datos correctamente'
        })
    }

    res.json({
        resultado: num1 + num2
    })
});

router.post('/subtract', (req = Request, res = Response) => {
    let { num1, num2 } = req.body;

    num1 = +num1;
    num2 = +num2;

    if (num1 === undefined || num2 === undefined || isNaN(num1) || isNaN(num2)) {
        return res.status(400).json({
            errorMessage: 'No se puede realizar la operacion, ingrese los datos correctamente'
        })
    }

    res.json({
        resultado: num1 - num2
    })
});

router.post('/multiply', (req = Request, res = Response) => {
    let { num1, num2 } = req.body;

    num1 = +num1;
    num2 = +num2;

    if (num1 === undefined || num2 === undefined || isNaN(num1) || isNaN(num2)) {
        return res.status(400).json({
            errorMessage: 'No se puede realizar la operacion, ingrese los datos correctamente'
        })
    }

    res.json({
        resultado: num1 * num2
    })
});

router.post('/division', (req = Request, res = Response) => {
    let { num1, num2 } = req.body;

    num1 = +num1;
    num2 = +num2;

    if (num1 === undefined || num2 === undefined || isNaN(num1) || isNaN(num2)) {
        return res.status(400).json({
            errorMessage: 'No se puede realizar la operacion, ingrese los datos correctamente'
        })
    }

    if (num2 === 0) {
        return res.status(400).json({
            errorMessage: 'No se puede dividir entre 0'
        })
    }

    res.json({
        resultado: num1 / num2
    })
});

module.exports = router;