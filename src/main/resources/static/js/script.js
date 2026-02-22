function validarCliente() {

    let nome = document.getElementById("nome").value;
    let cpf = document.getElementById("cpf_cnpj").value;
    let email = document.getElementById("email").value;

    if (nome === "") {
        alert("O nome é obrigatório!");
        return false;
    }

    if (cpf === "") {
        alert("O CPF é obrigatório!");
        return false;
    }

    if (email === "") {
        alert("O email é obrigatório!");
        return false;
    }

    alert("Cliente cadastrado com sucesso!");
    return false; // impede envio real (pois não há backend)
}

function validarProduto() {

    let nome = document.getElementById("nomeProduto").value;
    let preco = document.getElementById("preco").value;

    if (nome === "") {
        alert("O nome do produto é obrigatório!");
        return false;
    }

    if (preco === "" || preco <= 0) {
        alert("Informe um preço válido!");
        return false;
    }

    alert("Produto cadastrado com sucesso!");
    return false; // impede envio real
}

function calcularTotal() {

    const precoInput = document.getElementById("preco");
    const quantidadeInput = document.getElementById("quantidade");
    const valorTotalInput = document.getElementById("valorTotal");

    if (!precoInput || !quantidadeInput || !valorTotalInput) {
        return;
    }

    const preco = parseFloat(precoInput.value);
    const quantidade = parseInt(quantidadeInput.value);

    if (isNaN(preco) || isNaN(quantidade)) {
        valorTotalInput.value = "";
        return;
    }

    const total = preco * quantidade;

    valorTotalInput.value = total.toFixed(2);
}

function finalizarPedido() {

    let cliente = document.getElementById("cliente").value;
    let produto = document.getElementById("produto").value;

    if (cliente === "" || produto === "") {
        alert("Preencha todos os campos obrigatórios!");
        return false;
    }

    alert("Pedido finalizado com sucesso!");
    return false; // impede envio real
}

function salvarCliente() {

    const nome = document.getElementById("nome").value.trim();
    const cpfCnpj = document.getElementById("cpfCnpj").value.trim();
    const email = document.getElementById("email").value.trim();

    if (nome === "" || cpfCnpj === "" || email === "") {
        alert("Todos os campos são obrigatórios!");
        return;
    }

    const cliente = {
        nome: nome,
        cpfCnpj: cpfCnpj,
        email: email
    };

    fetch("/clientes", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(cliente)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Erro ao salvar cliente");
        }
        return response.json();
    })
    .then(data => {
        alert("Cliente salvo com sucesso!");
        document.getElementById("nome").value = "";
        document.getElementById("cpfCnpj").value = "";
        document.getElementById("email").value = "";
    })
    .catch(error => {
        alert("Erro ao salvar cliente!");
        console.error(error);
    });
}

function salvarProduto() {

    const nome = document.getElementById("nomeProduto").value.trim();
    const preco = document.getElementById("preco").value.trim();

    if (nome === "" || preco === "") {
        alert("Todos os campos são obrigatórios!");
        return;
    }

    const produto = {
        nome: nome,
        preco: preco
    };

    fetch("/produtos", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(produto)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Erro ao salvar produto");
        }
        return response.json();
    })
    .then(data => {
        alert("Produto salvo com sucesso!");
        document.getElementById("nomeProduto").value = "";
        document.getElementById("preco").value = "";
    })
    .catch(error => {
        alert("Erro ao salvar produto!");
        console.error(error);
    });
}

let produtosLista = [];

function carregarDadosPedido() {

    fetch("/clientes")
        .then(response => response.json())
        .then(clientes => {
            const select = document.getElementById("clienteSelect");
            select.innerHTML = "<option value=''>Selecione um cliente</option>";

            clientes.forEach(cliente => {
                select.innerHTML += 
                    `<option value="${cliente.id}">${cliente.nome}</option>`;
            });
        });

    fetch("/produtos")
        .then(response => response.json())
        .then(produtos => {
            produtosLista = produtos;
            const select = document.getElementById("produtoSelect");
            select.innerHTML = "<option value=''>Selecione um produto</option>";

            produtos.forEach(produto => {
                select.innerHTML += 
                    `<option value="${produto.id}">${produto.nome}</option>`;
            });
        });

}

function atualizarPreco() {

    const produtoId = document.getElementById("produtoSelect").value;

    const produto = produtosLista.find(p => p.id == produtoId);

    document.getElementById("preco").value = produto.preco;
}

function salvarPedido() {

    const clienteId = document.getElementById("clienteSelect").value;
    const produtoId = document.getElementById("produtoSelect").value;
    const quantidade = document.getElementById("quantidade").value;
    const preco = document.getElementById("preco").value;

    if (!clienteId) {
        alert("Selecione um cliente!");
        return;
    }

    if (!produtoId) {
        alert("Selecione um produto!");
        return;
    }
     
    if (quantidade === "") {
        alert("Informe a quantidade!");
        return;
    }

    const pedido = {
        cliente: { id: clienteId },
        produto: { id: produtoId },
        quantidade: quantidade,
        valorTotal: parseFloat(document.getElementById("valorTotal").value)
    };

    fetch("/pedidos", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(pedido)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Erro ao salvar pedido");
        }
        return response.json();
    })
    .then(data => {
        alert("Pedido salvo com sucesso!");
        document.getElementById("quantidade").value = "";
    })
    .catch(error => {
        alert("Erro ao salvar pedido!");
        console.error(error);
    });
}





