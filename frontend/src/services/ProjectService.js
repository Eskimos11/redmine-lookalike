import axios from 'axios';

const PROJECT_API_BASE_URL = 'http://localhost:8080/projects'
class ProjectService {
    getProjects(){
        return axios.get(PROJECT_API_BASE_URL);
    }

    createProject(project){
        return axios.post(PROJECT_API_BASE_URL, project);
    }
}

export default new ProjectService()