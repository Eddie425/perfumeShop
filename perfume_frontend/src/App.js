import React, { Component } from "react";
import Nav from "./nav/nav.js";
import StaffCard from "./staff/staffCard.js";
import './App.css';

class App extends Component {
  state = {};

  componentDidMount() {
    this.testApi();
  }

  testApi = () => {
    fetch("http://localhost:8080/api/test")
      .then((response) => response.text())
      .then((message) => {
        this.setState({ message: message });
      });
  };

  render() {
    return (
      <div className="App">
        <Nav />
        <header className="App-header">
          <StaffCard />
          <h3 className="App-title">{this.state.message}</h3>
        </header>

        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
      </div>
    );
  }
}

export default App;
