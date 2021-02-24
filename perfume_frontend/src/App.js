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
    fetch("https://perfumeshop.herokuapp.com/api/test")
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
      </div>
    );
  }
}

export default App;
