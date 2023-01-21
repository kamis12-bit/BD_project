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
import React, { Component } from 'react'
import logo from './logo.svg'
import './App.css'
import PersonComponent from './component/PersonComponent'
import ListPersons from './component/ListPersons'
import { Link, Routes, Route } from 'react-router-dom'

const App = () => (
  <div className='App'>
    <img src={logo} className='App-logo' alt='logo' />
    <div className='App-title'>
      <Main />
    </div>
  </div>
)

const Home = () => (
  <div>
    {' '}
    Hello world! <Link to='list-persons'>display people</Link>
  </div>
)

const Main = () => (
  <Routes>
    <Route path='/' element={<Home />} />
    <Route path='modify-person/:id' element={<PersonComponent />} />
    <Route path='list-persons' element={<ListPersons />} />
  </Routes>
)

/* Hello, {table.firstName} {table.lastName} this is
                the backend speaking and this is your avatar: {table.image} */

export default App
