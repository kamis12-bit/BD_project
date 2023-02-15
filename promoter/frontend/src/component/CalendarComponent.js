import React, {Component} from 'react'
import axios from 'axios'
import '../App.css'
import {Link} from 'react-router-dom'
import GoToMenu from './GoToMenu.js'

class CalendarComponent extends React.Component {
  constructor(props) {
    super(props)

    this.state = {}
  }

  componentDidMount() {

  }

  render() {
    return (
      <div>
        <GoToMenu/>{' '}
      </div>
    )
  }
}

export default CalendarComponent