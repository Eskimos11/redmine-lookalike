import React, { Component } from 'react';
import ProjectService from '../services/ProjectService';
import { Link } from "react-router-dom";

class ListProjectComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            projects: [{title: 'Redmine', description: 'asdasdzxc'}]
        }
        this.addProject = this.addProject.bind(this);
    }

    componentDidMount(){
        ProjectService.getProjects().then((res) => {
            this.setState({projects: res.data});
        });
    }

    addProject() {
        this.props.history.push('/project/new');
    }

    render() {
        return (
            <div>
                <div className='row'>
                    <div className='col-9'>
                        <div className='row border-bottom'>
                            <div className='col-11 mt-2'>
                                <h5 className='text-muted'>Projects</h5>
                            </div>

                            <div className='col-1 mt-2'>
                                <Link to = "/project/new">
                                    <button class="badge badge-success" onClick={this.addProject}>New</button>
                                </Link>
                            </div>
                        </div>

                        {
                            this.state.projects.map(
                                project => 
                                <div className='row'>
                                    <div className='col-11'>
                                        <div className='row'>
                                            <div className='col-12'>   
                                                <b>{project.title}</b>
                                            </div>
                                        </div>


                                        <div className='row'>
                                            <div className='col-12'>   
                                                <small>{project.description}</small>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            )
                        }
                        
                    </div>

                    <div className='col-3 border-left utility-panel'>
                        UTILITY PANEL
                    </div>
                </div>
            </div>
        );
    }
}

export default ListProjectComponent;