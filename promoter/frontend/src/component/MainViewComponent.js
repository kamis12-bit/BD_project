import React, { Component } from 'react'
import axios from 'axios'
import '../App.css'
import { Link } from 'react-router-dom'
import GoToMenu from './GoToMenu.js'

class MainViewComponent extends React.Component {
  constructor(props) {
    super(props)

    this.state = {
      mainView: [],
    }
  }

  componentDidMount() {
    axios
      .get('/api/event/main-view')
      .then((response) => {
        this.setState({
          mainView: response.data,
        })

        console.log(this.state.mainView)
      })
      .catch((error) => {
        console.log(error)
      })
  }

  render() {
    return (
      <div>
        {this.state.mainView.map((mainView) => {
          return (
            <p>
              <Link to={'/detail-view/' + mainView.id}>
                <div className='App-button'>
                  <div>
                    {mainView.name}
                    {mainView.isPublished ? '   ✅' : '   ❌'}
                  </div> <br />
                  beginDate: {mainView.beginDate} <br />
                  endDate: {mainView.endDate} <br />
                  <div>
                    {mainView.persons.map((person) => {
                      return (
                      <p>
                        {person.firstName} {person.lastName} <br />
                        {person.avatar}
                      </p>
                      )
                    })}
                  </div>
                </div>
              </Link>
            </p>
          )
        })}
        <GoToMenu />{' '}
      </div>
    )
  }
}

export default MainViewComponent
