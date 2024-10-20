import React, { Component } from 'react';
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      email: '',
      password: '',
      message: ''
    };

    this.login = this.login.bind(this);
  }

  login(e) {
    e.preventDefault(); // Impede o envio padrão do formulário

    // Verifica se o e-mail e a senha correspondem aos valores esperados
    if (this.state.email === 't.souza04@pucpr.br' && this.state.password === 'somativa') {
      this.setState({ message: 'Acessado com sucesso!' });
    } else {
      this.setState({ message: 'Usuário ou senha incorretos!' });
    }
  }

  render() {
    return (
      <div>
        <h3>Login</h3>
        <form onSubmit={this.login}>
          <input
            type="email"
            placeholder="E-mail"
            value={this.state.email}
            onChange={(e) => this.setState({ email: e.target.value })}
          />
          <br />
          <input
            type="password"
            placeholder="Senha"
            value={this.state.password}
            onChange={(e) => this.setState({ password: e.target.value })}
          />
          <br />
          <button type="submit">Enviar</button>
        </form>
        <label>{this.state.message}</label>
      </div>
    );
  }
}

export default App;
