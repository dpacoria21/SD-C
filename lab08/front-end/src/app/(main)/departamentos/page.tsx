import { SubmitButton } from '@/components/Form/SubmitButton';
import Table from './ui/Table';
import DepartmentForm from './ui/DepartmentForm';

export default function page() {

    return (
        <section className='w-full flex flex-col justify-center items-center mt-10'>
            
            <DepartmentForm/>

            <div className='mt-10'/>

            <Table />

        </section>
    );
}
