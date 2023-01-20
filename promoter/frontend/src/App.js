/* import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React again
        </a>
      </header>
    </div>
  );
}

export default App; */
// eslint-disable-next-line
import React, {Component, useState, useEffect} from 'react';
import logo from './logo.svg';
import './App.css';

function App () {
    const [message, setMessage] = useState("");

    useEffect(() => {
        fetch('/api/person/get/1')
            .then(response => response.text())
            .then(message => {
                setMessage(message);
            });
    },[])
    console.log(message);
    
    //const table = JSON.parse(message); //If uncommented, no message comes in
    return (
        <div className="App">
            <header className="App-header">
            <img src={logo} className="App-logo" alt="logo"/>
            <h1 className="App-title">
               {message}      </h1>
            </header>
            <p className="App-intro">
                To get started, edit <code>src/App.js</code> and save to reload.
            </p>
        </div>
    )
}
                /* Hello, {table.firstName} {table.lastName} this is
                the backend speaking and this is your avatar: {table.image} */

export default App;
