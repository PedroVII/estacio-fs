const { obterLivros, incluir, excluir } = require('../modelo/livro-dao');

const express = require('express');
const router = express.Router();

router.get('/', async (req, res) => {
    try {
        const livros = await obterLivros();
        res.json(livros);
    } catch (error) {
        res.status(500).json({ erro: 'Erro ao obter livros' });
    }
});

router.post('/', async (req, res) => {
    try {
        const livro = req.body;
        await incluir(livro);
        res.json({ mensagem: 'Livro incluído com sucesso' });
    } catch (error) {
        res.status(500).json({ erro: 'Falha ao incluir livro' });
    }
});

router.delete('/:_id', async (req, res) => {
    try {
        const codigo = req.params._id;
        await excluir(codigo);
        res.json({ mensagem: 'Livro excluído com sucesso' });
    } catch (error) {
        res.status(500).json({ erro: 'Falha ao excluir livro' });
    }
});

module.exports = router;