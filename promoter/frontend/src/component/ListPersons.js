import React, { Component } from 'react'
import axios from 'axios'
import '../App.css'
import { Link, Route, Routes } from 'react-router-dom'
import PersonComponent from './PersonComponent'

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
              {/* <Routes>
                <Route
                  path={'/modify-person/' + person.id}
                  element={<PersonComponent id={person.id} />}
                />
              </Routes> */}
            </p>
          )
        })}
      </div>
    )
  }
}

export default ListPersons
