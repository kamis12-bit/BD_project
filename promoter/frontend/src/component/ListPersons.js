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
              <Link to={'/modify-person/' + person.id} className='App-button'>
                {person.firstName} {person.lastName} {person.avatar}
              </Link>
            </p>
          )
        })}
        <GoToMenu />{' '}
      </div>
    )
  }
}

export default ListPersons
