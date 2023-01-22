import React, { Component } from 'react'
import '../App.css'
import { Link } from 'react-router-dom'

const GoToMenu = () => {
  return (
    <p>
      <Link to={'/'} className='App-button'>
        Go to main Menu
      </Link>
    </p>
  )
}

export default GoToMenu
