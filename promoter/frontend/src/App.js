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
    <Route path='add-person' element={<AddPerson />} />
  </Routes>
)

export default App
