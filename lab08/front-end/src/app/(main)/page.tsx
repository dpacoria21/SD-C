import Image from 'next/image';

export default function page() {
    return (
        <div className="flex flex-col justify-center items-center">
            <h1 className="text-3xl font-bold underline">
                Bienvenidos a nuestro Laboratorio 08 de Sistemas Distribuidos
            </h1>

            <ol className="list-decimal my-10">
                <li className="text-lg font-medium">Diego Ivan Pacori Anccasi</li>
                <li className="text-lg font-medium">Franco Luchiano Cardenas Martinez</li>
                <li className="text-lg font-medium">Henry Isaias Galvez Quilla</li>
            </ol>

            <Image
                src={'/image-sd.webp'}
                alt="programming"
                width={500}
                height={400} 
                className='rounded-lg'
            />
        </div>
    );
}
