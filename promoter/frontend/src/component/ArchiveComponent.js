import React, { Component } from 'react'
import axios from 'axios'
import '../App.css'
import { Link } from 'react-router-dom'
import GoToMenu from './GoToMenu.js'

class ArchiveComponent extends React.Component {
  constructor(props) {
    super(props)

    this.state = {
      archives: [],
    }
  }

  componentDidMount() {
    axios
      .get('/api/event/archived-view')
      .then((response) => {
        this.setState({
          archives: response.data,
        })

        console.log(this.state.archives)
      })
      .catch((error) => {
        console.log(error)
      })
  }

  render() {
    return (
      <div>
        {this.state.archives.map((archive) => {
          return (
            <p>
              <div className='App-button'>
                <div>
                  {archive.name}
                  {archive.isPublished ? '   ✅' : '   ❌'}
                </div> <br />
                beginDate: {archive.beginDate} <br />
                endDate: {archive.endDate} <br />
              </div>
            </p>
          )
        })}
        <GoToMenu />{' '}
      </div>
    )
  }
}

export default ArchiveComponent