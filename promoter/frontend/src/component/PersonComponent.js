import React, { Component } from 'react'
import axios from 'axios'
import '../App.css'
import { useParams } from 'react-router-dom'
import GoToMenu from './GoToMenu'

export function withRouter(Children) {
  return (props) => {
    const match = { params: useParams() }
    return <Children {...props} match={match} />
  }
}

class PersonComponent extends React.Component {
  constructor(props) {
    super(props)

    this.state = {
      id: 0,
      firstName: '',
      lastName: '',
      avatar: '',
    }
  }

  componentDidMount() {
    axios
      .get('/api/person/get/' + this.props.match.params.id)
      .then((response) => {
        this.setState({
          id: response.data.id,
          firstName: response.data.firstName,
          lastName: response.data.lastName,
          avatar: response.data.avatar,
        })

        console.log(this.state.id)
        console.log(this.state.firstName)
        console.log(this.state.lastName)
        console.log(this.state.avatar)
      })
      .catch((error) => {
        console.log(error)
      })
  }

  render() {
    return (
      <div>
        <p>
          Person:
          <button className='App-button'>{this.state.firstName}</button>
          <button className='App-button'>{this.state.lastName}</button>
          <button className='App-button'>{this.state.avatar}</button>
        </p>
        <GoToMenu />
      </div>
    )
  }
}

export default withRouter(PersonComponent)
