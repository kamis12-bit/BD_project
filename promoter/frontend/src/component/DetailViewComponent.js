import React, { Component } from 'react'
import axios from 'axios'
import '../App.css'
import { useParams } from 'react-router-dom'
import GoToMenu from './GoToMenu.js'

export function withRouter(Children) {
  return (props) => {
    const match = { params: useParams() }
    return <Children {...props} match={match} />
  }
}

class DetailViewComponent extends React.Component {
  constructor(props) {
    super(props)

    this.state = {
      id: 0,
      name: '',
      description: '',
      beginDate: '',
      endDate: '',
      archived: 0,
      isPublished: 0,
      persons: [],
      promoMessages: [],
    }
  }

  componentDidMount() {
    axios
      .get('/api/event/detail-view/' + this.props.match.params.id)
      .then((response) => {
        this.setState({
          id: response.data.id,
          name: response.data.name,
          description: response.data.description,
          beginDate: response.data.beginDate,
          endDate: response.data.endDate,
          archived: response.data.archived,
          isPublished: response.data.isPublished,
          persons: response.data.persons,
          promoMessages: response.data.promoMessages,
        })
      })
      .catch((error) => {
        console.log(error)
      })
  }

  render() {
    return (
      <div>
        <p>
          <div className='App-button'>
            <div>
              {this.state.name}
              {this.state.isPublished ? '   ✅' : '   ❌'}
            </div> <br />
            <div> {this.state.description} </div> <br />
            beginDate: {this.state.beginDate} <br />
            endDate: {this.state.endDate} <br />
            <div>
              {this.state.persons.map((person) => {
                return (
                <p>
                  {person.firstName} {person.lastName} <br />
                  {person.avatar}
                </p>
                )
              })}
            </div>
          </div>
        </p>
        <GoToMenu />{' '}
      </div>
    )
  }
}

export default withRouter(DetailViewComponent)
