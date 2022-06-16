import React, { Component } from 'react';
import ProjectService from '../services/ProjectService';

class CreateProjectComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            title: '',
            description: ''
        }

        this.changeTitleHandler = this.changeTitleHandler.bind(this);
        this.changeDescriptionHandler = this.changeDescriptionHandler.bind(this);
        this.saveProject = this.saveProject.bind(this);
    }

    saveProject = (e) => {
        e.preventDefault();
        let project = {title: this.state.title, description: this.state.description};
        ProjectService.createProject(project);
    }

    changeTitleHandler=(event) => {
        this.setState({title: event.target.value});
    }

    changeDescriptionHandler=(event) => {
        this.setState({description: event.target.value});
    }

    render() {
        return (
            <div>
                <div className='row'>
                    <div className='col-12'>
                            <div className='col-12 mt-2'>
                                <h5 className='text-muted'>New Project</h5>
                            </div>
                    </div>
                </div>
                <div className='row border gray'>
                    <form className='form-horizontal mt-3'>
                        <div className='form-inline form-group'>
                            <label className='control-label col-sm-2' for='title'><b>Title</b></label>
                            <div className='col-sm-3'>
                                <input id="title" className='form-control form-control-sm' value={this.state.title}
                                onChange={this.changeTitleHandler}/>
                            </div>
                        </div>
                        
                        <div className='form-inline form-group'>
                            <label className='control-label col-sm-2' for='description'><b>Description</b></label>
                            <div className='col-sm-3'>
                                <textarea id="description" className='form-control form-control-sm' rows='5' cols='100' 
                                value={this.state.description} onChange={this.changeDescriptionHandler}/>
                            </div>
                        </div>

                        <div className='row mb-3'>
                            <div className='col-12 text-center'>
                                <button className='btn btn-outline-success' onClick={this.saveProject}>create</button>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        );
    }
}

export default CreateProjectComponent;