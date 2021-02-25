import React, { Component } from "react";
import Nav from "./nav/Nav.js";
import StaffCard from "./staff/StaffCard.js";
import StaffDetail from "./staff/staffDetail/StaffDetail.js";
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: null,
      page: "home",
    };
  }

  state = {};

  setPage(pageLocation) {
    console.log("number => " + pageLocation);
    this.setState({
      page: pageLocation,
    });
  }

  componentDidMount() {
    // this.testApi();
  }

  testApi = () => {
    fetch("https://perfumeshop.herokuapp.com/api/test")
      .then((response) => response.text())
      .then((message) => {
        this.setState({ message: message });
      });
  };

  render() {
    let page;
    let statePage = this.state.page;
    if (this.state.page == null) {
      page = <main>Loading...</main>;
    } else {
      if (statePage === "home") {
        page = <StaffCard setPage={ this.setPage.bind(this) }/>;
      } else {
        page = <StaffDetail />;
      }
    }
    return (
      <div className="App">
        <Nav setPage={this.setPage.bind(this)} />
        <header className="App-header">
          {page}
          <h3 className="App-title">{this.state.message}</h3>
        </header>
      </div>
    );
  }
}

export default App;
