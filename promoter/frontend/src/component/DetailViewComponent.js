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
            {this.state.id} {this.state.name} {this.state.description} {this.state.beginDate} {this.state.endDate} {this.state.isPublished}
          </div>
        </p>
        <GoToMenu />{' '}
      </div>
    )
  }
}

export default withRouter(DetailViewComponent)
