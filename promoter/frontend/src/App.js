import React, { Component } from 'react'
import logo from './logo.svg'
import './App.css'
import PersonComponent from './component/PersonComponent'
import ListPersons from './component/ListPersons'
import MainViewComponent from './component/MainViewComponent'
import ArchiveComponent from './component/ArchiveComponent'
import CalendarComponent from './component/CalendarComponent'
import ThingsToCheck from './component/ThingsToCheck'
import MessageTypesComponent from './component/MessageTypesComponent'
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
    <div
      style={{
        display: 'inline-block',
        width: '300px',
        padding: '30px',
        fontSize: '30px',
        fontWeight: 'bold',
        backgroundColor: 'lightblue',
        textAlign: 'center',
        textDecoration: 'none'
      }}
     > This is the home page </div>

    <p>
      <Link to={'/main-view'} className='App-button-menu'> Main View </Link>
    </p>
    <p>
      <Link to={'/archive'} className='App-button-menu'> Archive </Link>
    </p>
    <p>
      <Link to={'/calendar'} className='App-button-menu'> Calendar </Link>
    </p>
    <p>
      <Link to={'/things-to-check'} className='App-button-menu'> Things to check </Link>
    </p>

    <br />

    <p>
      <Link to='list-persons' className='App-button-menu'> Persons </Link>
    </p>
    <p>
      <Link to='message-types' className='App-button-menu'> Message Types </Link>
    </p>
  </div>
)

const Main = () => (
  <Routes>
    <Route path='/' element={<Home />} />
    <Route path='person/:id' element={<PersonComponent />} />
    <Route path='list-persons' element={<ListPersons />} />
    <Route path='main-view' element={<MainViewComponent />} />
    <Route path='archive' element={<ArchiveComponent />} />
    <Route path='calendar' element={<CalendarComponent />} />
    <Route path='things-to-check' element={<ThingsToCheck />} />
    <Route path='message-types' element={<MessageTypesComponent />} />
    <Route path='add-person' element={<AddPerson />} />
  </Routes>
)

export default App
