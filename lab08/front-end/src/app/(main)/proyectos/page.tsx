import Table from './ui/Table';
import ProjectForm from './ui/ProjectForm';

export default function page() {

    return (
        <section className='w-full flex flex-col justify-center items-center mt-10'>
            
            <ProjectForm />

            <div className='mt-10'/>

            <Table />

        </section>
    );
}
