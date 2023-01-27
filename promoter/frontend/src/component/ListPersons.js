import React, { Component } from 'react'
import axios from 'axios'
import '../App.css'
import { Link } from 'react-router-dom'
import GoToMenu from './GoToMenu.js'

class ListPersons extends Component {
  constructor(props) {
    super(props)

    this.state = {
      persons: [],
    }
  }

  componentDidMount() {
    axios
      .get('/api/person/all')
      .then((response) => {
        this.setState({
          persons: response.data,
        })

        console.log(this.state.persons)
      })
      .catch((error) => {
        console.log(error)
      })
  }

  render() {
    return (
      <div>
        {this.state.persons.map((person) => {
          return (
            <p>
              <Link to={'/person/' + person.id} className='App-button'>
                {person.firstName} {person.lastName} <br />
                {person.avatar}
              </Link>
            </p>
          )
        })}
        <Link to={'/add-person/'} className='App-button'>
          Add new person
        </Link>
        <GoToMenu />
      </div>
    )
  }
}

export default ListPersons
